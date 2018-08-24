/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsadministrator.business.web.interfaces;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author Oni-sama
 */
public interface SMSServices {
    @GET("users/{user}/repos")
  Call<List<Object>> listRepos(@Path("user") String user);
}
