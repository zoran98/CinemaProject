import React, { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const AddProjection = () => {

    const emptyProjection = {
        filmId: -1,
        tipProjekcijeId: -1,
        salaId: -1,
        datumIVremePrikazivanja: "",
        cenaKarte: ""
    };

    const [projection, setProjection] = useState(emptyProjection);
    const [movie, setMovie] = useState([]);
    const [typeOfProjection, setTypeOfProjection] = useState([]);
    const [hall, setHall] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getData();
    }, [])

    const getData = () => {
        getMovie();
        getTypeOfProjection();
        getHall();
    };

    const doAdd = () => {
        CinemaAxios.post("/projekcije", projection)
        .then((res) => {
            console.log(res);
            setProjection(projection);
            navigate("/projections");
        })
        .catch((error) => {
            console.log(error);
            alert("Doslo je do greske prilikom dodavanja projekcije!")
        })
    };

    const getMovie = () => {
        CinemaAxios.get("/filmovi/forProjections")
        .then((res) => {
            console.log(res);
            setMovie(res.data);
        })
        .catch((error) => {
            console.log(error);
            alert("Doslo je do greske prilikom dobavljanja filma!");
        })
    };

    const getTypeOfProjection = () => {
        CinemaAxios.get("/tipoviProjekcija")
        .then((res) => {
            console.log(res);
            setTypeOfProjection(res.data);
        })
        .catch((error) => {
            console.log(error);
            alert("Doslo je do greske prilikom dobavljanja tipa projekcije!");
        })
    };

    const getHall = () => {
        CinemaAxios.get("/sale")
        .then((res) => {
            console.log(res);
            setHall(res.data);
        })
        .catch((error) => {
            console.log(error);
            alert("Doslo je do greske prilikom dobavljanja sale!");
        })
    };


    const canCreatePet = () => {
        return projection.datumIVremePrikazivanja != "" &&
        (projection.cenaKarte != "" && projection.cenaKarte >= 0 && projection.cenaKarte <= 9999 && projection.cenaKarte % 1 == 0)
    };

    const addValueInputChange = (e) => {
        let newProjection = { ...projection };

        const name = e.target.name;
        const value = e.target.value;

        newProjection[name] = value;

        setProjection(newProjection);

    };

  return (
    <div>
      <Form>
        <Form.Group>
          <Form.Label>Film</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="filmId"
            value={movie.filmId}
            as="select"
          >
            <option value={-1}>Odaberi film</option>
            {movie.map((mov) => {
              return (
                <option value={mov.id} key={mov.id}>
                  {mov.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Tip projekcije</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="tipProjekcijeId"
            value={typeOfProjection.tipProjekcijeId}
            as="select"
          >
            <option value={-1}>Odaberi tip projekcije</option>
            {typeOfProjection.map((top) => {
              return (
                <option value={top.id} key={top.id}>
                  {top.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Sala</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="salaId"
            value={hall.salaId}
            as="select"
          >
            <option value={-1}>Odaberi sala</option>
            {hall.map((hall) => {
              return (
                <option value={hall.id} key={hall.id}>
                  {hall.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Datum i vreme prikazivanja</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="datumIVremePrikazivanja"
            value={projection.datumIVremePrikazivanja}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Cena karte</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="cenaKarte"
            value={projection.cenaKarte}
            as="input"
          ></Form.Control>
        </Form.Group>
      </Form>
      <Button
        disabled={!canCreatePet()}
        variant="primary"
        onClick={() => doAdd()}
      >
        Dodaj projekcija
      </Button>
    </div>
  );
};

export default AddProjection;
