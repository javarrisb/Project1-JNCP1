import { useState, useEffect } from 'react';
import './GameStore.css';
import GamesCard from './GamesCard.js';
//import ConsoleCard from './ConsoleCard.js';
// import TShirtCard from './TShirtCard.js';
import GameStoreForm from './GameStoreForm.js';


function GameStore() {
    const [games, setGames] = useState([]);
    const [showForm, setShowForm] = useState(false);
    
    const [scopedGame, setScopedGame] = useState({});
  // const [scopedConsoles, setScopedConsoles] = useState({});
   //const [scopedTShirts, setScopedTShirts] = useState({});
    
    const [error, setError] = useState();

    useEffect(() => {
        fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/games")
            .then(response => response.json())
            .then(result => { setGames(result); })
            .catch(console.log);
    }
       

    function addClick() {
        setScopedGame({ id: 0, title: "Tetris", esrbRating: "", description: "", studio: "",});
        setShowForm(true);
    }

    function notify({ action, game, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }

       switch (action) {
           case "add":
               setGames([...games, game]);
               break;
           case "edit":
               setGames(games.map(e => {
                   if (e.gameId === game.gameId) {
                       return games;
                   }
                   return e;
               }));
               break;
           case "edit-form":
               setScopedGame(game);
               setShowForm(true);
               return;
           case "delete":
               setGames(games.filter(e => e.gameId !== game.gameId));
               break;
            default:
                break;
       }
        
        setError("");
        setShowForm(false);
    }

    if (showForm) {
        return <GameStoreForm game={scopedGame} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='gameTitle'>Games</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}> Add a Game </button>
                <table id='games'>
                    <tr>
                        <th>Title</th>
                        <th>ESRB Rating</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Studio</th>
                        <th>Quantity</th>
                    </tr>
                    <tbody>
                        {games.map(g => <GamesCard key={g.gameId} games={g} notify={notify} />)}
                        {/*console.map(c => <ConsoleCard key={c.consoleId} console={c} notify={notify} />)}
                        {/* {TShirts.map(r => <TShirtCard key={r.id} record={r} notify={notify} />)} */}
                    </tbody>
                </table>
            </div>
        </>
    )
}
    export default GameStore;