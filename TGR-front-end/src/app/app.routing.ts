import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';

import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LandingComponent } from './products/landing.component';
import { LoginComponent } from './login/login.component';
import { GeneralAuthGaurdService } from './home/@security/authgaurds/general-auth-gaurd.service';

const routes: Routes =[
    { path: 'home',component: HomeComponent },
    { path: 'user-profile',component: ProfileComponent },
    { path: 'products', component: LandingComponent ,canActivate:[GeneralAuthGaurdService]
  
  
  },
    { path: 'login',component: LoginComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
