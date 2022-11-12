package ca.com.rlsp.client;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        if (Client.listAll() == null){
            return HealthCheckResponse.down("Client is NOT ready");
        } else{
            return HealthCheckResponse.up("Client is ready");
        }
    }
}
