// handles individual table rows

function TShirtCard({ TShirts, notify }) {

    function handleDelete() {
        fetch((`http://localhost:8080/TShirt/${TShirts.id}`), {method: "Delete"})
        .then(() =>notify({ action: "delete", TShirts: TShirts }))
        .catch(error =>notify({ action: "delete", error: error}))
    }

    return (
        <tr key={TShirts.id}>
            <td>{TShirts.size}</td>
            <td>{TShirts.color}</td>
            <td>{TShirts.description}</td>
            <td>{TShirts.price}</td>
            <td>{TShirts.quantity}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", TShirts: TShirts })}>Edit</button>
            </td>
        </tr>
    );
}

export default TShirtCard;