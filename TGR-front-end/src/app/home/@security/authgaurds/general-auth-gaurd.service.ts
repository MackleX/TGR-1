import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivate, CanActivateChild, RouterModule, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';
import { Oauth2ConfigurerService } from '../oauth2/oauth2Configurer.service';

@Injectable({
  providedIn: 'root'
})
export class GeneralAuthGaurdService implements CanActivate  {

  constructor(private router: Router, private authConfigurer:Oauth2ConfigurerService,private currentRoute:ActivatedRoute) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    debugger
    return this.authConfigurer.isAuthenticated().then(authentificated => {
      if(!authentificated){
        alert("You can't access this resouce")
        this.router.navigate(['/login'])

        return false
      }else{
        return true
      }
    })
  }
}

