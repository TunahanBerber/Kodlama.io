package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductMenager;
import nLayeredDemo.core.LoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jLogger.JLoggerManager;


public class Main {

	public static void main(String[] args) {
		
		//To do Spring IoC ile iyile�tirelecek 14. Sat�r
		
		ProductService productService = new ProductMenager(new AbcProductDao(),new LoggerManagerAdapter());
		
		Product product=new Product(1, 2, "Elma", 2, 50);
		productService.add(product);
	}
}