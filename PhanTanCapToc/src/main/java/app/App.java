package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Category;
import entity.Product;

public class App {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Category category = new Category("Laptop");
		
		Product product1 = new Product("lenovo", "My Laptop", 1000, category);
		Product product2= new Product("Dell", "Nothing", 10, category);
		Product product3= new Product("Realme5", "My phone", 1000, category);
		
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		category.getProducts().add(product3);
		
		session.save(category);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
