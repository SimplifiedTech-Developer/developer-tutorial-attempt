import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  getProducts() {
    return [
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
    ];
  }

  constructor() {
  }
}
