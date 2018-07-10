<template>
    <article>
        <header>
            {{title}}
        </header>
        <section>
            <slot></slot>
        </section>
    </article>
</template>
<script>
export default {
    props: { title: String }
}
</script>
<style scoped>
article {
    position: relative;
    padding: 10px;
    width: 100%;
    border-radius: 5px;
    box-sizing: border-box;
}

header {
    font-size: 18px;
    color: #3c3c3c;
    height: 30px;
    border-bottom: 2px solid #3c3c3c;
    margin-bottom: 10px;
}

section {
    width: 100%;
    height: calc(100% - 130px);
}
</style>