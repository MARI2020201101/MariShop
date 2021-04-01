package com.mari.shop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mari.shop.domain.Attach;
import com.mari.shop.domain.Product;
import com.mari.shop.domain.User;
import com.mari.shop.model.NewProductModel;
import com.mari.shop.service.AdminService;
import com.mari.shop.service.ProductService;
import com.mari.shop.utils.UploadUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/admin/**")
@Log
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	private final ProductService productService;
	
	@GetMapping("/")
	public String index() {
		return "/admin/index";
	}
	//회원관리 메뉴 
	@GetMapping("/manageUser")
	public String manageUser(Model model) {
		log.info("manageuser-----------------------");
		List<User> userList = adminService.listAll();
		model.addAttribute("userList", userList);
		return "/admin/manageUser";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(Long userId, RedirectAttributes rttr) {
		int result = adminService.deleteUser(userId);
		if(result==1)
			rttr.addFlashAttribute("result","삭제 성공");
		else rttr.addFlashAttribute("result", "삭제 실패");
		return "redirect:/admin/manageUser";
			
	}
	@GetMapping("/manageProduct")
	public String manageProduct(Model model) {
		log.info("---------------------------------manageProduct");
		//List<Product> productList = productService.selectAll();
		//model.addAttribute("productList",productList);
		return "/admin/manageProduct";
	}
	@GetMapping("/updateProduct")
	public String updateProduct(Model model, Long productId) {
		Product product = productService.selectByProductId(productId);
		model.addAttribute("product",product);
		return "/admin/updateProduct";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(RedirectAttributes rttr, Product product) {
		int result = productService.update(product);
		if(result!=0) {
			rttr.addFlashAttribute("result","수정성공");
			return "redirect:/admin/manageProduct"; }
		else { rttr.addFlashAttribute("result","수정실패");
				return "redirect:/admin/manageProduct";}
	}
	@PostMapping("/deleteProduct")
	public String deleteProduct(RedirectAttributes rttr, Long productId) {
		log.info("--------------------------------------deleteProduct");
		int result = productService.delete(productId);
		if(result!=0) {
			rttr.addFlashAttribute("result","삭제성공");
			return "redirect:/admin/manageProduct"; }
		else { rttr.addFlashAttribute("result","삭제실패");
				return "redirect:/admin/manageProduct";}
	}
	
	@GetMapping("/insertProduct")
	public String insertProductForm() {
		return "/admin/insertProduct";
	}
	
	@PostMapping("/insertProduct")
	public String insertProduct(NewProductModel newProduct ,@RequestParam(value="img", required=false) MultipartFile img, RedirectAttributes rttr) {
		String uploadFilename ="";
		
		if(img!=null) {
		
		UUID uuid = UUID.randomUUID();
		uploadFilename = uuid.toString() + "_" + img.getOriginalFilename();
		File saveFile = new File(UploadUtils.realUploadFolder,uploadFilename);
		
		log.info("saved File name : " + saveFile.getName());
		log.info("saved File getAbsolutePath : " + saveFile.getAbsolutePath());
		log.info("saved File getPath : " + saveFile.getPath());
		try {
			img.transferTo(saveFile);
			Thumbnailator.createThumbnail(saveFile,new File(UploadUtils.realUploadFolder+"s_"+saveFile.getName()), 160, 160);
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		}
		newProduct.getAttaches().forEach(i-> log.info( 
				"\n new Product attaches :" + i.getUuid() + i.getImgName() + i.getUploadPath()));
		
		Product product = Product.builder()
				.productName(newProduct.getProductName())
				.price(newProduct.getPrice())
				.stock(newProduct.getStock())
				.categoryId(newProduct.getCategoryId())
				.detail(newProduct.getDetail())
				.img(UploadUtils.uploadFolder+uploadFilename)
				.thumbImg(UploadUtils.uploadFolder+"s_"+uploadFilename)
				.attaches(newProduct.getAttaches())
				.build();
		
									
		int result = productService.insert(product);
		if(result!=0) {
			rttr.addFlashAttribute("result","등록성공");
			return "redirect:/admin/insertProduct"; }
		else { rttr.addFlashAttribute("result","등록실패");
				return "redirect:/admin/insertProduct";
				
		}
	}
}
