import React from "react";
import { useEffect } from "react";
import { Table } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import { useState } from "react";

const Movies = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    getMovies(0);
  }, []);

  const getMovies = () => {
    CinemaAxios.get("/filmovi")
      .then((res) => {
        console.log(res);
        setMovies(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Nije uspelo dodavanje filmova!");
      });
  };

  return (
    <div>
      <h1>Filmovi</h1>
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Naziv</th>
            <th>Zanrovi</th>
            <th>Trajanje</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            <th>Godina proizvodnje</th>
          </tr>
        </thead>
        <tbody>
          {movies.map((mov) => {
            return (
              <tr key={mov.id}>
                <td>{mov.naziv}</td>
                <td>{mov.zanrovi}</td>
                <td>{mov.trajanje}</td>
                <td>{mov.distributer}</td>
                <td>{mov.zemljaPorekla}</td>
                <td>{mov.godinaProizvodnje}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </div>
  );
};

export default Movies;
