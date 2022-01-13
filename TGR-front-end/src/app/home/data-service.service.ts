import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  description:string;
  providers:string[];
  constructor() { }
}
