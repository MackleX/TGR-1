import { Component, OnInit } from '@angular/core';
import { Oauth2ConfigurerService } from '../home/@security/oauth2/oauth2Configurer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  focus;
  focus1;
  constructor(private oauth2Configurer:Oauth2ConfigurerService) { }
  ngOnInit(): void {
  }
  
  googleSignIn():void{
    this.oauth2Configurer.authenticate('google');
   
  }



}
