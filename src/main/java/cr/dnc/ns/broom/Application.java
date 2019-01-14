package cr.dnc.ns.broom;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AjpProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new TomcatCustomizer();
    }

    /**
     * Customizing tomcat to support AJP protocol
     */
    private static class TomcatCustomizer implements EmbeddedServletContainerCustomizer {

        @Value("${ajp.port}")
        private int ajpPort;

        @Value("${ajp.enabled}")
        private boolean ajpEnabled;

        @Override
        public void customize(ConfigurableEmbeddedServletContainer factory) {
            if (factory instanceof TomcatEmbeddedServletContainerFactory) {
                customizeTomcat((TomcatEmbeddedServletContainerFactory) factory);
            }
        }

        public void customizeTomcat(TomcatEmbeddedServletContainerFactory factory) {
            factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
                @Override
                public void customize(Connector connector) {
                // connector config
                }
            });
            if (ajpEnabled) {
                factory.addAdditionalTomcatConnectors(createAjpConnector());
            }
        }

        public Connector createAjpConnector() {
            Connector connector = new Connector("org.apache.coyote.ajp.AjpProtocol");
            try {
                connector.setProtocol("AJP/1.3");
                connector.setPort(ajpPort);
                return connector;
            } catch (Exception ex) {
                throw new IllegalStateException();
            }
        }
    }
}
