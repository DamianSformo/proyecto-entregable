import data from "./data";
import React, { Component } from "react";
import Opciones from "./Opciones";
import Recordatorio from "./Recordatorio";

const historial = [];

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      contador: 0,
      seleccionPrevia: "",
    };
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidUpdate( _ , prevState) {
    if (prevState.contador !== this.state.contador) {
      historial.push(this.state.seleccionPrevia);
    }
  }

  handleClick = (e) => {

    if (this.state.contador >= 7) {
      alert("Fin.");
    }

    else if(this.state.contador === 0 ){
      console.log("última selección: " + e);
      this.setState((prevState) => {
        return {
        contador:  e === "A" ? prevState.contador + 1 : prevState.contador + 2,
        seleccionPrevia: e
        }
      })
    }

    else if(this.state.contador%2 !== 0){
      console.log("última selección: " + e);
      this.setState((prevState) => {
        return {
        contador:  e === "A" ? prevState.contador + 2 : prevState.contador + 3,
        seleccionPrevia: e
        }
      })
    }

    else if(this.state.contador%2 === 0 ){
      console.log("última selección: " + e);
      this.setState((prevState) => {
        return {
        contador:  e === "A" ? prevState.contador + 1 : prevState.contador + 2,
        seleccionPrevia: e
        }
      })
    }

    console.log("historial: " + historial.map(
      (elemento) => (
        " " + elemento
      ),
    ));
  };

  render() {
    const {contador, seleccionPrevia} = this.state
    return (
      <div className="layout">
        <h1 className="historia">{data[contador].historia}</h1>
        <Opciones
          handleClick={this.handleClick}
          opcionA={data[contador].opciones.a}
          opcionB={data[contador].opciones.b}
        />
        <Recordatorio
          seleccionPrevia={seleccionPrevia}
          historial={historial.map(
            (elemento, index) => (
              <li key={index}>{elemento}</li>
            ),
          )}
        />
      </div>
    );
  }
}

export default Main;