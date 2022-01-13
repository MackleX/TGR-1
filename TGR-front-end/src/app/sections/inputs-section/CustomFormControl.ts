import { FormControl } from "@angular/forms";

export class CustomFormControl extends FormControl {
    private siteName:String;
    private siteDescription:String;
    private siteImage:String;
    constructor(...args){
        super(...args)
    }
    setSiteName(siteName){
        this.siteName = siteName;
    }
    getSiteName(){
        return this.siteName;
    }
    setSiteDescription(siteDescription:string){
        this.siteDescription = siteDescription;
        debugger
    }
    getSiteDescription(){
        return this.siteDescription;
    }
    setSiteImage(link){
        this.siteImage = link;
    }
    getSiteImage(){
        return this.siteImage;
    }
}