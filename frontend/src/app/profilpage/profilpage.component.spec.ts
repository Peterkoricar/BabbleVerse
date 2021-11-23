import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilpageComponent } from './profilpage.component';

describe('ProfilpageComponent', () => {
  let component: ProfilpageComponent;
  let fixture: ComponentFixture<ProfilpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
