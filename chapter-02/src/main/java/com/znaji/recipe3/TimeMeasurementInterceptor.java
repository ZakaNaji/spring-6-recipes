package com.znaji.recipe3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeMeasurementInterceptor implements HandlerInterceptor {

    public static final String TIMER = "TIMER";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        var sw = new StopWatch();
        sw.start();
        request.setAttribute(TIMER, sw);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) {
        var sw = (StopWatch) request.getAttribute(TIMER);
        sw.stop();
        modelAndView.addObject("processingTime", sw.getTotalTimeMillis());
    }
}
