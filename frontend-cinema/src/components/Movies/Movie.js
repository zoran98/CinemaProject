import React, { useEffect, useState } from "react";
import { Button, ButtonGroup, Table } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const Movie = () => {
  const [movie, setMovie] = useState({});
  const navigate = useNavigate();
  const routeParams = useParams();
  const [showButton, setShowButton] = useState(true);
  const [projections, setProjections] = useState([]);

  useEffect(() => {
    getMovie();
    getProjections();
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

  const getProjections = () => {
    CinemaAxios.get("/projekcije")
    .then((res) => {
      console.log(res);
      setProjections(res.data);
    })
    .catch((error) => {
      console.log(error);
      alert("Doslo je do greske prilikom dobavljanja projekcija!");
    })
  };

  const goToMovies = () => {
    navigate("/movies");
  };

  const goToProjections = () => {
    navigate("/projections");
  };

  const someFunction = (movId) => {
    if(movId === projections.filmId){
      if(projections.datumIVremePrikazivanja < Date.now()){
        return setShowButton(false);
      }
    }
  };

  const buyTicket = (movId) => {
    setShowButton(false);
    navigate("/buyTicket/" + movId);
    // alert("Kupili ste kartu!");
  };

  return (
    <div>
      <ButtonGroup style={{ marginTop: 25, float: "left" }}>
        <Button style={{ margin: 3, width: 150 }} onClick={() => goToMovies()}>
          Filmovi
        </Button>
        ,
        <Button
          style={{ margin: 3, width: 150 }}
          onClick={() => goToProjections()}
        >
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
            <th></th>
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
            <td>{showButton &&
              <Button
                hidden={someFunction(movie.id)}
                variant="success"
                onClick={() => buyTicket(movie.id)}
                style={{ marginLeft: 5 }}
              >
                Kupi kartu
              </Button>}
            </td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
};

export default Movie;
