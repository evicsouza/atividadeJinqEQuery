package br.edu.ifpe.jpa.jinq;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

public class EntityManagerHelper {

	private EntityManagerHelper() { }
	
	public static EntityManagerHelper getInstance() {
		return new EntityManagerHelper();
	}
	
	public <T, R> R execute(Class<T> classType, Function<JPAJinqStream<T>, R> action) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("MyPersicenceUnit");
		EntityManager em = fabrica.createEntityManager();

		JinqJPAStreamProvider streams = new JinqJPAStreamProvider(fabrica);

		try {
			return action.apply(streams.streamAll(em, classType));
		} finally {
			em.close();
			fabrica.close();
		}
	}
}
