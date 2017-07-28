package io.github.yexiaoxiaogo.SpringDemo;

public class ProductManage {
	
	private ProductDaoImp productDao;
	
	public ProductDaoImp getProductDao(){
		return productDao;
	}
	public void setProductDao(ProductDaoImp productDao){
		this.productDao = productDao;
	}
	public void addUser() {
		this.productDao.addProduct();
	}

}
