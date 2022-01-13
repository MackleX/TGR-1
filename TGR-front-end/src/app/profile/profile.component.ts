import { Component, OnInit } from '@angular/core';
import { Oauth2ConfigurerService } from '../home/@security/oauth2/oauth2Configurer.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {
    public photo;
    public name;
    constructor(private authConfigurer:Oauth2ConfigurerService) { }

    ngOnInit() {  this.authConfigurer.isAuthenticated().then(
        cond => this.changeAuth(cond)
    )

    }
    changeAuth(cond){
        if(cond){
        this.photo = localStorage.getItem("image")
        this.name = localStorage.getItem("image")
        }
    }
}
