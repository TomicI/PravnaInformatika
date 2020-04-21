package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import io.jsonwebtoken.*;


public class JWTokenFilter extends OncePerRequestFilter {

  //  @Value("projekatPravna")
 //   private String appname;

    @Value("10000")
    private int expires;

    @Value("secret")
    private String secret;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        try {

            String jwt = getJwt(request);
            System.out.println("jwt : ovde " + jwt);
            if (jwt != null  && validateJwtToken(jwt)) {
                String username = getUserNameFromJwtToken(jwt);

                User userDetails = userRepository.findByUsername(username).get();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("sve ok: ovde " + authentication.getName());
            }
        } catch (Exception e) {
           System.out.println("Can NOT set user authentication -> Message: {}" + e);
        }

        filterChain.doFilter(request, response);

    }


    public String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String pom= authHeader.replace("Bearer ", "");
            System.out.println("pom pre if " + pom);
            if (pom.contains("\"")){
                System.out.println("uslo ovde ");
                pom=pom.substring(1, pom.length()-1);
                System.out.println("pom if " + pom);
            }else{
                System.out.println("nije uslo ovde ");
            }
            return pom;
        }

        return null;
    }

    public boolean validateJwtToken(String authToken) {
        System.out.println("********************************authToken = " + authToken);
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: ", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: ", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: ", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: ", e);
        }

        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

}