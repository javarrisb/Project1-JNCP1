import { useState, useEffect } from 'react';
import './GameStore.css';
import GamesCard from './GamesCard.js';
import ConsoleCard from './ConsoleCard.js';
import TShirtCard from './TShirtCard.js';
import GameStoreForm from './GameStoreForm.js';

function GameStore() {
    const [gameStores, setGameStore] = useState([]);
    const [showForm, setShowForm] = useState(false);
    // const [scopedGameStore, setScopedGameStore] = useState({});
    const [error, setError] = useState();

    useEffect(() =>{
        fetch("http://localhost:8080/")
        .then(response => response.json())
        .then(result => setGameStore(result))
        .catch(console.log);

    }, []);
    
    function addClick() {
    }

    function notify({ action, gamesStores, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        // switch (action) {
        //     case "delete":
        //         setGamesStore(gameStores.filter(r => r.id !== gamesStores.id))
        //         break;
        // }
    }

    if (showForm) {
        return <GameStoreForm record={GameStore} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='gameTitle'>Games Store</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a Selection</button>
                <table id='gameStores'>
                    <tr>
                        <th>Games</th>
                        <th>Consoles</th>
                        <th>T-Shirts</th>
                    </tr>
                    <tbody>
                        {gameStores.map(r => <GamesCard key={r.gameId} game={r} notify={notify} />)}
                        {gameStores.map(r => <ConsoleCard key={r.gameId} game={r} notify={notify} />)}
                        {gameStores.map(r => <TShirtCard key={r.gameId} game={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default GameStore;