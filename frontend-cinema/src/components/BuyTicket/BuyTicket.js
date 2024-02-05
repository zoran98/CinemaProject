import { useEffect, useState } from "react";
import { Button, ButtonGroup, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const BuyTicket = () => {

    const emptyTicket = {
        naziv: "",
        projekcijaDatum: "",
        tipProjekcije: "",
        sala: "",
        cenaKarte: "",
        sedista: "",
        ukupnaCena: ""
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
    goToMovies();
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
          <Form.Label>Datum Projekcije</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="projekcijaDatum"
            value={buyTicket.projekcijaDatum}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Tip Projekcije</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="tipProjekcije"
            value={buyTicket.tipProjekcije}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Sala</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="sala"
            value={buyTicket.sala}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Cena Karte</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="cenaKarte"
            value={buyTicket.cenaKarte}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Sedista</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="sedista"
            value={buyTicket.sedista}
            as="input"
          ></Form.Control>
        </Form.Group>

        <Form.Group>
          <Form.Label>Ukupna Cena</Form.Label>
          <Form.Control
            onChange={(e) => addValueInputChange(e)}
            name="ukupnaCena"
            value={buyTicket.ukupnaCena}
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
