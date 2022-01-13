import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtAuthManagerService } from '../authgaurds/jwt-auth-manager.service';
declare var gapi:any;

@Injectable({
  providedIn: 'root'
})
export class Oauth2ConfigurerService {
  firstTime= true;
  gapiSetup: boolean | undefined;
  authInstance: gapi.auth2.GoogleAuth| undefined ;
  user: any;
  photo: string;
  name: string;
  error: any;
  constructor(private router:Router) { }
  getName(): string{
    return this.name;
  }
  getPhoto(): string{
    return this.photo
  }
  async initGoogleAuth(): Promise<void> {
 
    const pload = new Promise((resolve) => {
      gapi.load('auth2', resolve);
    });

    return pload.then(async () => {
      await gapi.auth2
        .init({ client_id: '304615553988-vo00igf42uo4tkhtn070gunkpnb6bsec.apps.googleusercontent.com' })
        .then((auth: gapi.auth2.GoogleAuth | undefined) => {
          this.gapiSetup = true;
          this.authInstance = auth;
          
        });
    });

  }

  getSetup():Boolean|undefined {
    return this.gapiSetup;
  }

  async isAuthenticated(): Promise<boolean> {
    if (!this.gapiSetup) {
      await this.initGoogleAuth();
    }
    return this.authInstance?.isSignedIn.get();
    
  }

  async authenticate(provider:String): Promise<gapi.auth2.GoogleUser> {

    if (!this.getSetup()) {
      await this.initGoogleAuth();
    }

    return new Promise( async () => {

      await this.authInstance?.signIn().then(

        (user) => {

          
        let id_token = user.getAuthResponse().id_token;
        localStorage.setItem("image", user.getBasicProfile().getImageUrl())
        localStorage.setItem("name", user.getBasicProfile().getName())
        localStorage.setItem("token", id_token)

        this.router.navigate(['/home'])
        error => {
          this.error = error;
          alert("Can't connect to google");
        };

    });

  

  
  })
}


  async desauthenticate(): Promise<boolean>{
    if (!this.gapiSetup) {
       await this.initGoogleAuth();
    }
    localStorage.clear();
    gapi.auth2.getAuthInstance().disconnect();
    return true;
  }
  
  
}
