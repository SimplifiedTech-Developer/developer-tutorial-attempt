import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: any

  constructor(productService: ProductService) {

    //Declaring Array List Of Products
    /*this.products = [
      {
        "id": 1,
        "name": "T-Shirt",
        "brand": "Polo",
        "price": 800
      },
      {
        "id": 2,
        "name": "Phone",
        "brand": "Huawei",
        "price": 965
      },
      {
        "id": 3,
        "name": "Laptop",
        "brand": "Acer",
        "price": 10000
      }
    ]*/
    this.products = productService.getProducts();
  }


  ngOnInit(): void {
  }

}
