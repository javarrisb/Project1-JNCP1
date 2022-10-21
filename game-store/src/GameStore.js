import { useState, useEffect } from 'react';
import './GameStore.css';
import GamesCard from './GamesCard.js';
import ConsoleCard from './ConsoleCard.js';
// import TShirtCard from './TShirtCard.js';
import GameStoreForm from './GameStoreForm.js';


function GameStore() {
    const [games, setGames] = useState([]);
    const [showForm, setShowForm] = useState(false);
    
    const [scopedGame, setScopedGame] = useState({});
    // const [scopedConsoles, setScopedConsoles] = useState({});
    // const [scopedTShirts, setScopedTShirts] = useState({});
    
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080")
        .then(response => response.json())
        .then(result => setGames(result))
        .catch(console.log);
    }, []);

    function addClick() {
        const now = new Date();
        setScopedGame({ id: 0, title: "", esrbRating: "", description: "", studio: "", year: now.getFullYear() });
        setShowForm(true);
    }

    function notify({ action, record, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }

        // switch (action) {
        //     case "add":
        //         setGames([...games, games]);
        //         break;
        //     case "edit":
        //         setGames(records.map(e => {
        //             if (e.id === record.id) {
        //                 return games;
        //             }
        //             return e;
        //         }));
        //         break;
        //     case "edit-form":
        //         setScopedGame(game);
        //         setShowForm(true);
        //         return;
        //     case "delete":
        //         setGames(games.filter(e => e.id !== id));
        //         break;
        // }
        
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
                <h1 i='gameTitle'>Games</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}> Add a Game </button>
                <table id='games'>
                    <tr>
                        <th>Title</th>
                        <th>ESRN Rating</th>
                        <th>Description</th>
                        <th>Studio</th>
                    </tr>
                    <tbody>
                        {games.map(r => <GamesCard key={r.id} record={r} notify={notify} />)}
                        {console.map(r => <ConsoleCard key={r.id} record={r} notify={notify} />)}
                        {/* {TShirts.map(r => <TShirtCard key={r.id} record={r} notify={notify} />)} */}
                    </tbody>
                </table>
            </div>
        </>
    )
}
    export default GameStore;