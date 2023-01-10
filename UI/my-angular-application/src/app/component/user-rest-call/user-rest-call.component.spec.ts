import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRestCallComponent } from './user-rest-call.component';

describe('UserRestCallComponent', () => {
  let component: UserRestCallComponent;
  let fixture: ComponentFixture<UserRestCallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRestCallComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRestCallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
