import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {UserComponent} from './component/user/user.component';
import {ProductComponent} from './component/product/product.component';
import {FormsModule} from "@angular/forms";
import {ProductService} from "./service/product.service";
import {UserRestCallComponent} from './component/user-rest-call/user-rest-call.component';
import {HttpClientModule} from "@angular/common/http";
import {BookComponent} from './component/book/book.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ProductComponent,
    UserRestCallComponent,
    BookComponent
  ],
  //Import Modules | Libraries Here
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  //Register Services Here
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
