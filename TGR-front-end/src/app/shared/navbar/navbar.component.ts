import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, NavigationStart } from '@angular/router';
import { Location, PopStateEvent } from '@angular/common';
import { Oauth2ConfigurerService } from 'src/app/home/@security/oauth2/oauth2Configurer.service';
import { OnChanges } from '@angular/core';
import { DoCheck } from '@angular/core';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{
    public isCollapsed = true;
    public isAuthtificated;
    public photo;
    public name;
    private lastPoppedUrl: string;
    private yScrollStack: number[] = [];
    
    constructor(public location: Location, private router: Router,  private authConfigurer:Oauth2ConfigurerService) {
        router.events.subscribe((val) => {
           
            this.changeAuth();
        });
    }
    ngOnChange(){
        console.log("test")
    }

    ngOnInit() {
      

      this.router.events.subscribe((event) => {
        this.isCollapsed = true;
        if (event instanceof NavigationStart) {
           if (event.url != this.lastPoppedUrl)
               this.yScrollStack.push(window.scrollY);
       } else if (event instanceof NavigationEnd) {
           if (event.url == this.lastPoppedUrl) {
               this.lastPoppedUrl = undefined;
               window.scrollTo(0, this.yScrollStack.pop());
           } else
               window.scrollTo(0, 0);
       }
     });
     
     this.location.subscribe((ev:PopStateEvent) => {
         this.lastPoppedUrl = ev.url;
     });

     this.changeAuth()
     
     debugger
    }
    changeAuth(){
        debugger
        this.authConfigurer.isAuthenticated().then(
            condition => 
            {
                console.log(condition)
                if(condition == true){
                    this.photo = localStorage.getItem("image")
                    this.name = localStorage.getItem("name")
                    this.isAuthtificated = true
                    
                }
            }
            
            )
    }
    isHome() {
        var titlee = this.location.prepareExternalUrl(this.location.path());

        if( titlee === '#/home' ) {
            return true;
        }
        else {
            return false;
        }
    }
    isDocumentation() {
        var titlee = this.location.prepareExternalUrl(this.location.path());
        if( titlee === '#/documentation' ) {
            return true;
        }
        else {
            return false;
        }
    }
    logout(){
        this.authConfigurer.desauthenticate()
        this.isAuthtificated = false;
    }
}