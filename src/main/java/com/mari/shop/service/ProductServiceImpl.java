package com.mari.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mari.shop.domain.Attach;
import com.mari.shop.domain.Product;
import com.mari.shop.mapper.ProductMapper;
import com.mari.shop.model.Criteria;
import com.mari.shop.model.PageObject;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	private final ProductMapper productMapper;
	@Override
	public List<Product> selectAll() {
		return productMapper.selectAll();
	}
	@Override
	public List<Product> selectByCategoryId(Long categoryId) {
		return productMapper.selectByCategoryId(categoryId);
	}
	@Override
	public Product selectByProductId(Long productId) {
		return productMapper.selectByProductId(productId);
	}
	@Override
	public int delete(Long productId) {
		return productMapper.delete(productId);
	}
	@Override
	public int update(Product product) {
		return productMapper.update(product);
	}
	@Override
	@Transactional
	public int insert(Product product) throws Exception{
		int result = 0;
		result = productMapper.insert(product);
		for(Attach a: product.getAttaches()) {
			result += productMapper.insertAttach(a);
		}
		return result;
	}
	@Override
	public List<Product> selectWithPage(PageObject pageObject) {
		return productMapper.selectWithPage(pageObject);
	}
	@Override
	public int countAll() {
		return 0;
	}
	@Override
	public int countAll(Criteria cri) {
		return productMapper.countAll(cri);
	}
	@Override
	public List<Product> selectByCategoryIdWithPage(PageObject pageObject) {
		return productMapper.selectByCategoryIdWithPage(pageObject);
	}
	@Override
	public List<Product> list(PageObject pageObject) {
		return productMapper.list(pageObject);
	}
	@Override
	public List<Attach> selectAttach(Long productId) {
		return productMapper.selectAttach(productId);
	}

}
