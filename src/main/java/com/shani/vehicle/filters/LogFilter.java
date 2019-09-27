package com.shani.vehicle.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.logic.LogController;
import com.shani.vehicle.utils.DateUtils;

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

	@Autowired
	LogController logController;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		Log log = new Log();

		log.setTimeStamp(DateUtils.getCurrentTime());
		log.setHttpMethod(httpRequest.getMethod());
		log.setPath(httpRequest.getRequestURI());
		log.setClientIP(httpRequest.getRemoteAddr());

		// set vehicleId for mostActiveVehicle
		String regex = "/vehicles/(\\d+)";
		Pattern replace = Pattern.compile("\\d+");
		Matcher matcher = replace.matcher(log.getPath());
		if (log.getPath().matches(regex)) {
			if (matcher.find()) {
				String strId = matcher.group();
				long resultInt = Long.parseLong(strId);
				log.setVehicleId(resultInt);
			}
		}

		logController.createLog(log);

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

}
