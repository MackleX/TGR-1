import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { DataServiceService } from '../home/data-service.service';
import { Product } from './products.model';
import { RequestModel } from './requestModel';

@Component({
    selector: 'app-landing',
    templateUrl: './landing.component.html',
    styleUrls: ['./landing.component.scss']
})

export class LandingComponent implements OnInit {
  waiting: boolean = true;
  products: Product[] = [];
  keywords: String[];
  providers: string[];
  isloading: boolean;
  description: string;
  page: number = 1;
  array = [];  
  sum = 0;  
  throttle = 300;  
  scrollDistance = 1;  
  scrollUpDistance = 2;  
  direction = "";  
  modalOpen = false;  
  photos: any;  
  start: number = 0;  





  focus: any;
  focus1: any;
  
  constructor(private http: HttpClient, private ds:DataServiceService) { }

  ngOnInit() {

    this.description = this.ds.description
    this.providers = this.ds.providers
    this.getProducts(false,this.description);
    this.isloading = true;
  }


  getProducts(byKeywords:boolean,description = "") {  
  
  const params = byKeywords ? new HttpParams().set('byKeywords', "true") : new HttpParams().set('byKeywords', "false");
  const body = byKeywords ? JSON.stringify(new RequestModel(this.providers,null,this.keywords)): JSON.stringify(new RequestModel(this.providers,this.description,null));
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      "access-token": localStorage.getItem('token')
    }),
    params
  };
 
    this.http.post<Product[]>('http://localhost:9000/products/'+ this.page,body, httpOptions
    ).subscribe((data => {
      
      this.products = this.products.concat(data['products']);
      this.keywords = data['keywords'];
      this.sum += this.products.length;
      this.page += 1;
      this.isloading = false;
      this.waiting = false;
      debugger;


  }).bind(this))

  }  

  onScrollDown(ev) {  
    if(this.waiting == false){
    this.start = this.sum;  
    this.getProducts(true);
    this.waiting = true;
    this.direction = "down";  
    }
  }  

}
