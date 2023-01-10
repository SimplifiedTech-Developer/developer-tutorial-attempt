import {Component, OnInit} from '@angular/core';
import {BookService} from "../../service/book.service";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: any;

  constructor(private bookService: BookService) {

  }

  ngOnInit(): void {
    this.books = this.bookService.getBooks().subscribe(data => this.books = data);
  }

}
