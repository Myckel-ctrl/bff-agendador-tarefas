package com.bff_agendador_tarefas.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class FeignAuthorizationInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes == null) {
            return;
        }

        String authorizationHeader = attributes.getRequest().getHeader(AUTHORIZATION_HEADER);

        if (authorizationHeader != null) {
            template.header(AUTHORIZATION_HEADER, authorizationHeader);
        }
    }
}
