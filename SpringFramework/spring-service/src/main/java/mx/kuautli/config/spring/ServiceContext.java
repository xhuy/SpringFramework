package mx.kuautli.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages = "mx.kuautli.service")
public class ServiceContext {

}
