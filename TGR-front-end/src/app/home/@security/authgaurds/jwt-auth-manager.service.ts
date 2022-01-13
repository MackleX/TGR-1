import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtWrapper } from './JwtWrapper';
const url:string = "http://localhost:8089/api/jwe";
@Injectable({
  providedIn: 'root'
})

export class JwtAuthManagerService {
  jwt:JwtWrapper;
  error:String;

  constructor(private http: HttpClient) { }

  injectJwtIntoHeaders(access_token:string,provider:string){
    debugger

    this.fetchJwt(access_token,provider).subscribe(
      (data:JwtWrapper) => {this.jwt = {... data};
      console.log(data);    
      debugger},
      (error) => {debugger} 
    );
    
  }

  fetchJwt(access_token:string,provider:string){
    let headers = new HttpHeaders();
    headers = headers.append('access-token', access_token);
    headers = headers.append('token-provider', provider);
    debugger
    return this.http.get<JwtWrapper>(url, {headers})
  }


}
