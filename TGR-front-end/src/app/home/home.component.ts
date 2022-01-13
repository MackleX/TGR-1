import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { fadeAnimation } from 'src/assets/animations/fade.animation';
@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  @ViewChild("taget") MyProp: ElementRef;
  
    model = {
        left: true,
        middle: false,
        right: false
    };


    focus;
    focus1;
    constructor() { }

    ngOnInit() {}

    scroll() {
        this.MyProp.nativeElement.scrollIntoView({ behavior: "smooth", block: "start" });
    }

}
