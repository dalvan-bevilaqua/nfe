package br.com.ntk.hibernate;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtilTeste 
{
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration()
								.configure()
								//.addPackage("br.com.domain")
								//.addAnnotatedClass(User.class)
								//.addAnnotatedClass(br.com.domain.System.class)
								//.addAnnotatedClass(Transacao.class)	
								//.addAnnotatedClass(Estabelecimento.class)
								//.addAnnotatedClass(Portador.class)
								//.addAnnotatedClass(Pedido.class)
								//.addAnnotatedClass(FormaPagamento.class)
								.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}