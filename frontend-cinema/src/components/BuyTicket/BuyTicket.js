import { useEffect, useState } from "react";
import { Button, ButtonGroup, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const BuyTicket = () => {

    const emptyTicket = {
        naziv: "",
        reziser: "",
        glumci: "",
        zanrovi: "",
        trajanje: "",
        distributer: "",
        zemljaPorekla: "",
        godinaProizvodnje: "",
        opis: ""
    }

  const navigate = useNavigate();
  const [movie, setMovie] = useState({});
  const [buyTicket, setBuyTicket] = useState(emptyTicket);
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
        alert("Doslo je do greske prilikom dobavljanja filma!");
    });
  };

  const goToMovies = () => {
    navigate("/movies");
  };

  const addValueInputChange = (e) => {};

  const canCreatePet = () => {};

  const doAdd = () => {

  };

  return (
    <div>
      <h1>Kupovina karte</h1>
      
      <Form>
        <Form.Group>
          <Form.Label>Naziv filma</Form.Label>
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
            value={buyTicket.reziser}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Glumci</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="glumci"
            value={buyTicket.glumci}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Zanrovi</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="zanrovi"
            value={buyTicket.zanrovi}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Trajanje</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="trajanje"
            value={buyTicket.trajanje}
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
            value={buyTicket.distributer}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Zemlja porekla</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="zemljaPorekla"
            value={buyTicket.zemljaPorekla}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Godina proizvodnje</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="godinaProizvodnje"
            value={buyTicket.godinaProizvodnje}
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
            value={buyTicket.opis}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Button
          disabled={!canCreatePet()}
          variant="primary"
          onClick={() => doAdd()}
        >
          Kupi kartu
        </Button>
      </Form>
    </div>
  );
};

export default BuyTicket;
