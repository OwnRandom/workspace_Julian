import { Component, OnInit } from '@angular/core';
import { ArticulosService } from 'src/app/services/articulos.service';



@Component({
  selector: 'app-lista-articulos',
  templateUrl: './lista-articulos.page.html',
  styleUrls: ['./lista-articulos.page.scss'],
})
export class ListaArticulosPage implements OnInit {

  listaArticulo:any 
  titulo:String= "titulo"
  price:String= "precio"
  imagenUrl:String= "imagenUrl"
  
  titulo1:String="Lista de productos"
  

  constructor(private _articulosService: ArticulosService) { }


  ngOnInit() {
    this._articulosService.get_articulos().subscribe(data=>
      {
        this.listaArticulo = data;
        this.listaArticulo = this.listaArticulo.products;
        console.log(this.listaArticulo)
      })
  }
}
