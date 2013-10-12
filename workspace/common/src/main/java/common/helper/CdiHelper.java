package common.helper;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CdiHelper {

	public static <T> T getBeanInstance(Class<T> clazz,
			final Class<? extends Annotation> scope) throws NamingException {
		InitialContext initialContext = new InitialContext();
		Object lookup = initialContext.lookup("java:comp/BeanManager");
		BeanManager beanManager = (BeanManager) lookup;
		final Context context = beanManager.getContext(scope);
		final Set<Bean<?>> beans = beanManager.getBeans(clazz);
		final Bean<T> bean = (Bean<T>) beanManager.resolve(beans);
		final CreationalContext<T> creationalContext = beanManager
				.createCreationalContext(bean);
		return context.get(bean, creationalContext);
	}
}
