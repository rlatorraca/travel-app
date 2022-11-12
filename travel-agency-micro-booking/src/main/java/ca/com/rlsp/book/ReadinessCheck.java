package ca.com.rlsp.book;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        if (Booking.listAll() == null){
            return HealthCheckResponse.down("Booking is NOT ready");
        } else{
            return HealthCheckResponse.up("Booking is ready");
        }
    }
}
