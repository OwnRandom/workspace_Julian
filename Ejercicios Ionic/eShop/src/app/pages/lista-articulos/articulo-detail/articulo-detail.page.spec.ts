import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ArticuloDetailPage } from './articulo-detail.page';

describe('ArticuloDetailPage', () => {
  let component: ArticuloDetailPage;
  let fixture: ComponentFixture<ArticuloDetailPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticuloDetailPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
