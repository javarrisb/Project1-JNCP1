// handles add & edit functionality; used record store as template

import { useState } from 'react';

function GameStoreForm({ gameStoreRecord: initialGameStoreRecord, notify }) {

    const [gameStoreRecord, setGameStoreRecord] = useState(initialGameStoreRecord);
    const isAdd = initialGameStoreRecord.id === 0;

    function handleChange(evt) {
        const clone = { ...gameStoreRecord };
        clone[evt.target.name] = evt.target.value;
        setGameStoreRecord(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = isAdd ? "http://localhost:8080/" : `http://localhost:8080/${gameStoreRecord.id}`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 204;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(gameStoreRecord)
        };

        fetch(url, init)
            .then(response => {
                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return gameStoreRecord;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                gameStoreRecord: result
            }))
            .catch(error => notify({ error: error }));

    }

    return (
        <>
            <h1>{gameStoreRecord.id > 0 ? "Edit" : "Add"} Games </h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title">Game Title</label>
                    <input type="text" id="title" name="title"
                        className="form-control"
                        value={gameStoreRecord.title} onChange={handleChange} />
                </div>
                {/* <div className="mb-3">
                    <label htmlFor="album">Album</label>
                    <input type="text" id="album" name="album"
                        className="form-control"
                        value={gameStoreRecord.album} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="year">Year</label>
                    <input type="text" id="year" name="year"
                        className="form-control"
                        value={gameStoreRecord.year} onChange={handleChange} />
                </div> */}
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default GameStoreForm;