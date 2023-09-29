import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const AddMovie = () => {

    const emptyMovie = {
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

const [movie, setMovie] = useState(emptyMovie);
const navigate = useNavigate();

const doAdd = () => {
    CinemaAxios.post("/filmovi/", movie)
    .then((res) => {
        console.log(res)
        setMovie(movie)
        navigate("/movies")
    })
    .catch((error) => {
        console.log(error)
        alert("Doslo je do greske prilikom dodavanja filma!")
    })
};

const canCreatePet = () => {
    return movie.naziv != "" &&
    movie.reziser != "" &&
    movie.glumci != "" &&
    movie.zanrovi != "" &&
    (movie.trajanje != "" && movie.trajanje >= 0 && movie.trajanje <= 9999 && movie.trajanje % 1 == 0) &&
    movie.distributer != "" &&
    movie.zemljaPorekla != "" &&
    (movie.godinaProizvodnje != "" && movie.godinaProizvodnje >= 0 && movie.godinaProizvodnje <= 9999 && movie.godinaProizvodnje % 1 == 0) &&
    movie.opis != ""
};

const addValueInputChange = (e) => {
    let newMovie = { ...movie }

    const name = e.target.name;
    const value = e.target.value;

    newMovie[name] = value;
    setMovie(newMovie);
};

    return (
        <div>
            <h1>Dodavanje filma</h1>
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

                <Button disabled={!canCreatePet()} variant="primary" onClick={() => doAdd()}>
                    Dodaj film
                </Button>
            </Form>
        </div>
    );
}

export default AddMovie;