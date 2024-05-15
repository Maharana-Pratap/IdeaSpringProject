package com.example.cqrsaxon.config;

import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Component
public class AxonConfig {
        // omitting other configuration methods...
        public void configureTokenClaimValues(EventProcessingConfigurer processingConfigurer) {
            TrackingEventProcessorConfiguration tepConfig =
                    TrackingEventProcessorConfiguration.forSingleThreadedProcessing()
                            .andTokenClaimInterval(1000, TimeUnit.MILLISECONDS)
                            .andEventAvailabilityTimeout(2000, TimeUnit.MILLISECONDS);

            processingConfigurer.registerTrackingEventProcessorConfiguration("my-processor", config -> tepConfig);
        }
}
