import { html, classMap } from '../lib.js';

export const input = (label, type, name, value = '', hasError) => {
    if (type == 'textarea') {
        return html`
            <label class=${classMap({ error: hasError })}><span>${label}</span><textarea name=${name} .value=${value}></textarea></label>`;
    } else {
        return html`
            <label class=${classMap({ error: hasError })}><span>${label}</span><input type=${type} name=${name}
                    .value=${value}></label>`;
    }
};