import React, { useEffect, useState } from "react";
import { Button, ButtonGroup, Table } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const Movie = () => {
  const [movie, setMovie] = useState({});
  const navigate = useNavigate();
  const routeParams = useParams();

  useEffect(() => {
    getMovie();
  }, []);

  const getMovie = () => {
    CinemaAxios.get("/filmovi/" + routeParams.id)
      .then((res) => {
        console.log(res);
        setMovie(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Nije uspelo dobavljanje filma!");
      });
  };

  const goToMovies = () => {
    navigate("/movies");
  };

  const goToProjections = () => {
    navigate("/projections");
  };

  return (
    <div>
      <ButtonGroup style={{ marginTop: 25, float: "left" }}>
        <Button style={{ margin: 3, width: 150 }} onClick={() => goToMovies()}>
          Filmovi
        </Button>,
        <Button style={{ margin: 3, width: 150 }} onClick={() => goToProjections()}>
          Projekcije
        </Button>
      </ButtonGroup>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Naziv</th>
            <th>Reziser</th>
            <th>Glumci</th>
            <th>Zanrovi</th>
            <th>Trajanje</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            <th>Godina proizvodnje</th>
            <th>Opis</th>
          </tr>
        </thead>
        <tbody>
          <tr key={movie.id}>
            <td>{movie.naziv}</td>
            <td>{movie.reziser}</td>
            <td>{movie.glumci}</td>
            <td>{movie.zanrovi}</td>
            <td>{movie.trajanje}</td>
            <td>{movie.distributer}</td>
            <td>{movie.zemljaPorekla}</td>
            <td>{movie.godinaProizvodnje}</td>
            <td>{movie.opis}</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
};

export default Movie;
