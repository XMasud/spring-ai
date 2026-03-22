package mmrana.com.spring_ai.config;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.spec.McpServerTransport;
import mmrana.com.spring_ai.service.DogAdoptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.mcp.server.sse.SseServerTransport;

@Configuration
public class McpConfiguration {

    @Bean
    public McpServer mcpServer(McpServerTransport transport, DogAdoptionService dogAdoptionService){
        return McpServer.using(transport)
                .serverInfo("Dog-Adoption-Server", "1.0.0")
                .toolHandlers(dogAdoptionService)
                .build();
    }

    @Bean
    public McpServerTransport mcpServerTransport() {
        return new SseServerTransport("/mcp/sse");
    }
}
