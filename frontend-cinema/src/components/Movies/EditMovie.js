import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const EditMovie = () => {

const [movie, setMovie] = useState({});
const routeParams = useParams();
const navigate = useNavigate();

useEffect(() => {
    getData();
}, []);

const getData = () => {
    getMovie();
};

const getMovie = () => {
    CinemaAxios.get("/filmovi/" + routeParams.id)
    .then((res) => {
        console.log(res);
        setMovie(res.data);
    })
    .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja filma!");
    })
};

const addValueInputChange = (e) => {
    let editetMovie = { ...movie }

    const name = e.target.name;
    const value = e.target.value;

    editetMovie[name] = value;
    setMovie(editetMovie);
};

const doEdit = () => {
  CinemaAxios.put("/filmovi/" + routeParams.id, movie)
  .then((res) => {
    console.log(res);
    navigate("/movies");
  })
  .catch((error) => {
    console.log(error);
    alert("Doslo je do greske prilikom izmene filma!");
  })
};

  return (
    <dvi>
      <h1>Izmena filma</h1>
      <Form>
        <Form.Group>
          <Form.Label>Naziv</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="naziv"
            value={movie.naziv}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Reziser</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="reziser"
            value={movie.reziser}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Glumci</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="glumci"
            value={movie.glumci}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Zanrovi</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="zanrovi"
            value={movie.zanrovi}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Trajanje</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="trajanje"
            value={movie.trajanje}
            as="input"
            type="number"
            min="0"
            step="1"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Distributer</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="distributer"
            value={movie.distributer}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Zemlja porekla</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="zemljaPorekla"
            value={movie.zemljaPorekla}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Godina proizvodnje</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="godinaProizvodnje"
            value={movie.godinaProizvodnje}
            as="input"
            type="number"
            min="0"
            step="1"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Opis</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="opis"
            value={movie.opis}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Button
          variant="primary"
          onClick={() => doEdit()}
        >
          Izmeni film
        </Button>
      </Form>
    </dvi>
  );
};

export default EditMovie;
